package sample.monitoring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

@Entity
@Value
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Product {

  @Id
  @GeneratedValue
  @NonFinal
  private Long id;

  private String title;

  @ManyToOne
  private Category category;

  public static Product of(String title, Category category) {
    return new Product(null, title, category);
  }

}
