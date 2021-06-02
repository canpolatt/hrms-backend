package hrms.management.core.utilities.imageUploaders;

import hrms.management.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

public interface ImageService {
    DataResult<Map> upload(MultipartFile multipartFile) throws IOException;
    DataResult<Map> delete (String id) throws IOException;
}
