package fr.eni.annuairebo;

public class Employe {
    int idEmployee;
    String nomEmployee;
    String emailEmployee;

    public Employe(int idEmployee, String nomEmployee, String emailEmployee) {
        this.idEmployee = idEmployee;
        this.nomEmployee = nomEmployee;
        this.emailEmployee = emailEmployee;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "idEmployee=" + idEmployee +
                ", nomEmployee='" + nomEmployee + '\'' +
                ", emailEmployee='" + emailEmployee + '\'' +
                '}';
    }
}
