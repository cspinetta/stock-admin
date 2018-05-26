package sample.monitoring;


import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import lombok.val;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import sample.monitoring.model.Product;
import sample.monitoring.model.Category;
import sample.monitoring.repositories.ProductRepository;
import sample.monitoring.repositories.CategoryRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class Server {

  public static void main(String[] args) {
    SpringApplication.run(Server.class, args);
  }

  @Bean
  CommandLineRunner init(CategoryRepository categoryRepository, ProductRepository productRepository) {
    return (evt) -> {
      Random r = new Random();
      val books = categoryRepository.save(Category.of("Books"));
      val clothing = categoryRepository.save(Category.of("Clothing"));
      val electronics = categoryRepository.save(Category.of("Electronics"));
      val movies = categoryRepository.save(Category.of("Movies"));
      val home = categoryRepository.save(Category.of("Home"));

      val categories = Arrays.asList(books, clothing, electronics, movies, home);

      productRepository.save(Product.of("Yo, Robot", books));
      productRepository.save(Product.of("H&M Jean Men 46", clothing));
      productRepository.save(Product.of("Tablet Samsung M41", electronics));
      productRepository.save(Product.of("Hang Over 3", movies));
      productRepository.save(Product.of("Tostadora Ven", home));

      IntStream.range(1,41)
          .forEach(
              i -> {
                val category = categories.get(r.nextInt(categories.size()));
                productRepository.save(Product.of("Product " + i, category));
              });
    };
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {

      System.out.println("Let's inspect the beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      }

    };
  }

}