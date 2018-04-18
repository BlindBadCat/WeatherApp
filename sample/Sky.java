package sample;

public class Sky {
    private String desck;
    private String iconType;

    public Sky(String desck, String iconType) {
        this.desck = desck;
        this.iconType = iconType;
    }

    public String getDesck() {
        return desck;
    }

    public void setDesck(String desck) {
        this.desck = desck;
    }

    public String getIconType() {
        return iconType;
    }

    public void setIconType(String iconType) {
        this.iconType = iconType;
    }

    @Override
    public String toString() {
        return "Sky{" +
                "desck='" + desck + '\'' +
                ", iconType='" + iconType + '\'' +
                '}';
    }
}
