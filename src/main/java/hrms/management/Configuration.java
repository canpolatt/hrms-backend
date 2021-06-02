package hrms.management;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import hrms.management.core.utilities.imageUploaders.CloudinaryService;
import hrms.management.core.utilities.imageUploaders.ImageService;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    public ImageService imageService(){
        return new CloudinaryService();
    }
}
