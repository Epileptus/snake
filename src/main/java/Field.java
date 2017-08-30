import lombok.Data;

@Data
class Field {
    String content;
    Field(String content){
        this.content=content;
    }
}
