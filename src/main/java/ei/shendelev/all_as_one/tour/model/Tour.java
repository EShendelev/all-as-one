package ei.shendelev.all_as_one.tour.model;

import lombok.Data;

@Data
public class Tour {
    private Integer id;
    private Integer gameId;
    private Boolean isSpecial;
    private Integer tourNumber;
    private String question;

}
