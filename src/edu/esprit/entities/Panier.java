
package edu.esprit.entities;


public class Panier {
    private int id;
    private int qtpanier;
    private int valid;
    private int Id_prod;
    private int IdUser;

    public Panier() {
    }

    public Panier(int qtpanier, int valid, int Id_prod, int IdUser) {
        this.qtpanier = qtpanier;
        this.valid = valid;
        this.Id_prod = Id_prod;
        this.IdUser = IdUser;
    }

    public Panier(int id, int qtpanier, int valid, int Id_prod, int IdUser) {
        this.id = id;
        this.qtpanier = qtpanier;
        this.valid = valid;
        this.Id_prod = Id_prod;
        this.IdUser = IdUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtpanier() {
        return qtpanier;
    }

    public void setQtpanier(int qtpanier) {
        this.qtpanier = qtpanier;
    }

    public int getValid() {
        return valid;
    }

    public void setValid(int valid) {
        this.valid = valid;
    }

    public int getId_prod() {
        return Id_prod;
    }

    public void setId_prod(int Id_prod) {
        this.Id_prod = Id_prod;
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    @Override
    public String toString() {
        return "Panier{" + "id=" + id + ", qtpanier=" + qtpanier + ", valid=" + valid + ", Id_prod=" + Id_prod + ", IdUser=" + IdUser + '}';
    }
}