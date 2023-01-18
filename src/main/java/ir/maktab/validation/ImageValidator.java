package ir.maktab.validation;

import ir.maktab.exception.NotFoundException;
import ir.maktab.exception.ValidationException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

public class ImageValidator {
    public static boolean validateFileExistence(String path) {
        Path paths = Paths.get(path);
        if (!Files.exists(paths))
            throw new NotFoundException("image not found");
        return true;
    }

    public static boolean validateFilePass(String path) {
        Optional<String> optionalPathExtension = Optional.of(path)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(path.lastIndexOf(".") + 1));
        String pathExtension = optionalPathExtension.get();
        if (!(pathExtension.equalsIgnoreCase("jpg") || pathExtension.equalsIgnoreCase("jpeg")))
            throw new ValidationException("the image is not valid,image format must be jpg");
        return true;
    }

    public static boolean validateImageSize(String path) throws IOException {
        Path paths = Paths.get(path);
        if (!(Files.size(paths) / 1024 > 300))
            throw new ValidationException("the image is not valid,image size must be less than 300 kb");
        return true;
    }
}
