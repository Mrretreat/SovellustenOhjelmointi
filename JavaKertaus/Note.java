enum Color {
    RED, BLUE, GREEN, YELLOW, ORANGE, PURPLE
}

public class Note {
    private String content;
    private Color backgroundColor;

    public Note(){
        this.content = "";
        this.backgroundColor = Color.RED;
    }

    public Note(String content, Color backgroundColor){
        this.content = content;
        this.backgroundColor = backgroundColor;
    }

    public String getContent(){
        return content;
    }

    public Color getBackgroundColor(){
        return backgroundColor;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public void setBackgroundColor(Color backgroundColor ){
        this.backgroundColor = backgroundColor;
    }

    public void PrintNote() {
        System.out.println("Content: " + content);
    }
    public String toString(){
        return "Content: " + content + ", BackgroundColor: " + backgroundColor;
    }
}
