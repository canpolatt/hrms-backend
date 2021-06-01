package hrms.management.core.utilities.imageUploaders;

import hrms.management.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface ImageService {
    DataResult<Map> save(MultipartFile file);
}
