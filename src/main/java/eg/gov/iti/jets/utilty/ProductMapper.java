package eg.gov.iti.jets.utilty;

import eg.gov.iti.jets.model.Category;
import eg.gov.iti.jets.model.Image;
import eg.gov.iti.jets.model.Product;
import eg.gov.iti.jets.model.dto.ProductDto;

import java.util.HashSet;
import java.util.Set;

public class ProductMapper {
    public static ProductDto mapToProductDto(Product product) {
//        Long productId, String productName,
//                String description, String manufacturingName,
//                String manufacturingDate, String expirationDate,
//        int quantity, Set<String> categories, String price,
//                String primaryImage, Set<String> images) {
        Set<String> categories = new HashSet<>(0);
        Set<Category> originalCategories = product.getCategories();
        for (Category category : originalCategories) {
            categories.add(category.getCategoryName());
        }

        String expireDate = (product.getExpirationDate() != null) ? product.getExpirationDate().toString() : "";
        Image primaryImage = product.getPrimaryImage();
        //String imagePath = primaryImage.getImagePath(); nulllllllllllllllllll
        String imagePath = "/iti-store/images?imageId=" + primaryImage.getImageId();
        Set<Image> originalImages = product.getImages();
        Set<String> images = new HashSet<>(0);
        for (Image image : originalImages) {
            images.add(image.getImagePath());
        }
        return new ProductDto(product.getProductId(),
                product.getProductName(), product.getDescription(),
                product.getManufacturingName(),
                product.getManufacturingDate().toString(),
                expireDate
                , product.getQuantity(),
                categories, "" + product.getSellPrice(), imagePath, images);

    }


}
