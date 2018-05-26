package sample.monitoring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
public class Category {

  @Id
  @GeneratedValue
  @NonFinal
  private Long id;

  private String title;

  public static Category of(String title) {
    return new Category(null, title);
  }

}