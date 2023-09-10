package me.muse.CrezyBackend.domain.Inquiry;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.muse.CrezyBackend.domain.account.entity.Profile;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Inquiry {
    @Id
    @Column(name = "inquiryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inquiryId;
    private String inquiryTitle;
    private String inquiryContent;
    private List<String> inquiryImageNames;
    @CreationTimestamp
    private LocalDate createInquiryDate;
    @ManyToOne
    private Profile profile;

}
