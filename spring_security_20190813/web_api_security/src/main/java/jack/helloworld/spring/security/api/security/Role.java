package jack.helloworld.spring.security.api.security;

import lombok.Data;

@Data
public class Role {

    private Integer id;
    private String name;


    public Role(){

    }

    public Role(String name) {
        this.name = name;
    }
}