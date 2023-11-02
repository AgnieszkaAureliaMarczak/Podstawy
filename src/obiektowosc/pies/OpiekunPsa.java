package obiektowosc.pies;

public class OpiekunPsa {

    public void nakarmPsa(Pies pies) {
        pies.setCzyNakarmiony(true);
        pies.setWaga(pies.getWaga() + pies.ileJedzeniaDziennieWkg(pies.getWaga()));
    }

}
