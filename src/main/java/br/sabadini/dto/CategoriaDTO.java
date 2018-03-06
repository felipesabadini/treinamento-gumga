package br.sabadini.dto;

public class CategoriaDTO {

    private String id;

    public CategoriaDTO() {}
    public CategoriaDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
