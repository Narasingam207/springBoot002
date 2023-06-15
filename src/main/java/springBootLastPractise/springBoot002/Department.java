package springBootLastPractise.springBoot002;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="department")
public class Department {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "dId")
    private int dId;
    private String domain;
    private String company;

}
