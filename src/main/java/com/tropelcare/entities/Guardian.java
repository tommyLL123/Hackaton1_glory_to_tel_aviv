import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "guardians", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Guardian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 60)
    private String displayName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String notificationEmail;

    @Column(nullable = false)
    private Instant createdAt;

    @OneToMany(mappedBy = "guardian")
    private List<Tropel> tropels;

    @OneToMany(mappedBy = "guardian")
    private List<TropelSignal> signals;
}
