package ei.shendelev.mainGame.tour.model;

import lombok.Data;

@Data
public class Tour {
    private Integer id;
    private Integer gameId;
    private Boolean isSpecial;
    private Integer tourNumber;
    private String question;

}
