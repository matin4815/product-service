package com.matin.productservice.service.product;

import com.matin.productservice.dal.entity.Product;
import com.matin.productservice.dal.repository.ProductRepository;
import com.matin.productservice.dto.comment.CommentDto;
import com.matin.productservice.dto.product.ProductDisplayDto;
import com.matin.productservice.dto.product.ProductDto;
import com.matin.productservice.mapper.ToProductDtoMapper;
import com.matin.productservice.mapper.ToProductMapper;
import com.matin.productservice.service.comment.CommentService;
import com.matin.productservice.service.vote.VoteService;
import com.matin.productservice.utils.pagination.PageableFactory;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private static final Integer FIRST_PAGE = 0;
    private static final Integer COMMENTS_FOR_MAIN_PAGE = 3;

    private final ProductRepository productRepository;
    private final ToProductMapper toProductMapper = Mappers.getMapper(ToProductMapper.class);
    private final ToProductDtoMapper toProductDtoMapper = Mappers.getMapper(ToProductDtoMapper.class);

    @Autowired
    @Lazy
    private CommentService commentService;

    @Autowired
    @Lazy
    private VoteService voteService;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Boolean createProduct(ProductDto productDto) throws Exception {
        try {
            Product product = toProductMapper.productDtoToProduct(productDto);
            productRepository.save(product);
            return true;
        } catch (Exception e) {
            log.error("Failed to create product: {}", productDto, e);
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()) {
            log.warn("No products were found");
            throw new RuntimeException("No products were found!");
        }
        return products.stream().map(toProductDtoMapper::toProductDto).toList();
    }

    @Override
    public ProductDto getProductByName(String name) {
        Optional<Product> product = productRepository.findByName(name);
        return checkProductPresent(product);
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()) {
            log.warn("Requested product with ID {} does not exist", id);
            throw new RuntimeException("Item was not found");
        }
        return product;
    }

    @Override
    public List<ProductDto> getProductsPaginated(Integer page) {
        Pageable pageable = PageableFactory.createPageable(page);
        List<Product> products = productRepository.findAllByIsVisibleTrue(pageable);
        return getProductCommentAndVoteForMainPage(products);
    }

    @Override
    @Transactional
    public Boolean changeProductDisplaySetting(ProductDisplayDto productDisplayDto) {
        try {
            Optional<Product> product = getProductById(productDisplayDto.getProductId());
            product.get().setIsVisible(productDisplayDto.getEnable());
            return true;
        } catch (Exception e) {
            log.error("Failed to change product display setting for product ID: {}", productDisplayDto.getProductId(), e);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Boolean changeProductCommentSetting(ProductDisplayDto productDisplayDto) {
        try {
            Optional<Product> product = getProductById(productDisplayDto.getProductId());
            product.get().setCanComment(productDisplayDto.getEnable());
            return true;
        } catch (Exception e) {
            log.error("Failed to change product comment setting for product ID: {}", productDisplayDto.getProductId(), e);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Boolean changeProductVoteSetting(ProductDisplayDto productDisplayDto) {
        try {
            Optional<Product> product = getProductById(productDisplayDto.getProductId());
            product.get().setCanVote(productDisplayDto.getEnable());
            return true;
        } catch (Exception e) {
            log.error("Failed to change product vote setting for product ID: {}", productDisplayDto.getProductId(), e);
            throw new RuntimeException(e.getMessage());
        }
    }

    private List<ProductDto> getProductCommentAndVoteForMainPage(List<Product> products) {
        return products.stream()
                .map(product -> {
                    ProductDto productDto = toProductDtoMapper.toProductDto(product);
                    // Set comments
                    productDto.setComments(commentService.getProductCommentsForMainPage(product, FIRST_PAGE, COMMENTS_FOR_MAIN_PAGE));

                    // Set votesCount and averageVote
                    productDto.setVotesCount(voteService.getVoteCountByProductAndState(product));
                    productDto.setAverageVote(voteService.getAverageVoteValueByProductAndState(product));

                    return productDto;
                })
                .toList();
    }

    private ProductDto checkProductPresent(Optional<Product> product) {
        if (product.isPresent()) {
            return toProductDtoMapper.toProductDto(product.get());
        } else {
            log.warn("Requested product does not exist");
            throw new RuntimeException("Item was not found");
        }
    }
}
