package top.kwrcee.sortcourse.manage.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Week {
    //务必有两个参数的构造方法
    private Integer day;
    private Integer time;
}
