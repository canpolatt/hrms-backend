package hrms.management.core.utilities.imageUploaders;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import hrms.management.core.utilities.results.DataResult;
import hrms.management.core.utilities.results.ErrorDataResult;
import hrms.management.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CloudinaryService implements ImageService{
    Cloudinary cloudinary;

    @Autowired
    public CloudinaryService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    public DataResult<Map> save (MultipartFile file) {
        try{
            Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
            return new SuccessDataResult<Map>(uploadResult);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return new ErrorDataResult<Map>();

    }


}
