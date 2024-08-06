package mate.academy.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.lib.Component;
import mate.academy.lib.Inject;
import mate.academy.model.Product;
import mate.academy.service.FileReaderService;
import mate.academy.service.ProductParser;
import mate.academy.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {
    @Inject
    private FileReaderService fileReaderService;
    @Inject
    private ProductParser productParser;

    @Override
    public List<Product> getAllFromFile(String filePath) {
        List<String> lines = fileReaderService.readFile(filePath);
        return lines.stream()
                .map(productParser::parse)
                .collect(Collectors.toList());
    }
}
