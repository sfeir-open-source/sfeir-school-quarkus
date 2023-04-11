import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;
import java.util.Random;

@Entity
public class Character extends PanacheEntity {

    @Column(unique = true, nullable = false)
    public String name;
    @Column(nullable = false)
    public int speed;
    @Column(precision = 2, nullable = false)
    public float acceleration;

    public static Character findByName(String name){
        return find("name", name).firstResult();
    }

    public static Character random() {
        List<Character> all = listAll();
        int index = new Random().nextInt(all.size());
        return all.get(index);
    }
}
