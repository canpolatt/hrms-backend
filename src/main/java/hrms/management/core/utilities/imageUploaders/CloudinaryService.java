package hrms.management.core.utilities.imageUploaders;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import hrms.management.core.utilities.results.DataResult;
import hrms.management.core.utilities.results.ErrorDataResult;
import hrms.management.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CloudinaryService implements ImageService{
    private Cloudinary cloudinary;
    private Map<String, String> valuesMap = new HashMap<>();

    @Autowired
    public CloudinaryService() {
        valuesMap.put("cloud_name","dplmlhani" );
        valuesMap.put("api_key", "622355694111298" );
        valuesMap.put("api_secret","8xm-ZIrNGigxdXP03T_9XclDmng" );
        cloudinary = new Cloudinary(valuesMap);
    }

    public DataResult<Map> upload (MultipartFile multipartFile) throws IOException {
        Map<String , Object > options = new HashMap<>();
        var allowedFormats = Arrays.asList("png","jpg","jpeg");
        options.put("allowed_formats",allowedFormats);
        File file = convert(multipartFile);
        Map result= null;
        try {
            result = cloudinary.uploader().upload(file, options);
        }catch (Exception e){
            return new ErrorDataResult<>(e.getMessage());
        }
        file.delete();
        return new SuccessDataResult<>(result);

    }
    public DataResult<Map> delete (String id) throws IOException {
        Map<String , Boolean> options = new HashMap<>();
        options.put("invalidate",true);
        Map result = cloudinary.uploader().destroy(id,options);
        return new SuccessDataResult<>(result);
    }


    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }


}
