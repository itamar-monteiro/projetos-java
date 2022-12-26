package classes;

import java.util.Date;

public class Cidadao extends ClasseBase {
    private Date dataPrimeiraDose;
    private Date dataSegundaDose;
    private Date dataTerceiraDose;
    private Date dataQuartaDose;

    public Date getDataPrimeiraDose() {
        return dataPrimeiraDose;
    }

    public void setDataPrimeiraDose(Date dataPrimeiraDose) {
        this.dataPrimeiraDose = dataPrimeiraDose;
    }

    public Date getDataSegundaDose() {
        return dataSegundaDose;
    }

    public void setDataSegundaDose(Date dataSegundaDose) {
        this.dataSegundaDose = dataSegundaDose;
    }

    public Date getDataTerceiraDose() {
        return dataTerceiraDose;
    }

    public void setDataTerceiraDose(Date dataTerceiraDose) {
        this.dataTerceiraDose = dataTerceiraDose;
    }

    public Date getDataQuartaDose() {
        return dataQuartaDose;
    }

    public void setDataQuartaDose(Date dataQuartaDose) {
        this.dataQuartaDose = dataQuartaDose;
    }
    
    public void cadastrarCidadao(){
    
    }
}
