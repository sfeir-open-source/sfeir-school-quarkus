import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;
import java.util.Random;

@Entity
public class Character extends PanacheEntity {

  @NotNull
  @Size(min = 3, max = 30)
  @Column(unique = true, nullable = false)
  public String name;

  @NotNull
  @Positive
  @Column(nullable = false)
  public int speed;

  @NotNull
  @Positive
  @Column(precision = 2, nullable = false)
  public float acceleration;

  @NotNull
  @Column(nullable = false)
  public CharacterType type;

  public static Character findByName(String name) {
    return find("name", name).firstResult();
  }

  public static List<Character> findByType(CharacterType type) {
    return find("type", type).list();
  }

  public static Character random() {
    List<Character> all = listAll();
    int index = new Random().nextInt(all.size());
    return all.get(index);
  }
}
