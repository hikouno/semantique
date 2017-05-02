package egg;
import java.util.ResourceBundle;
import mg.egg.eggc.runtime.libjava.messages.NLS;
public class MiniJavaMessages extends NLS {
  private static final long serialVersionUID = 1L;
  private static final String BUNDLE_NAME = "MiniJava";
  private MiniJavaMessages() {
  // Do not instantiate
  }
  static {
  NLS.initializeMessages(BUNDLE_NAME, egg.MiniJavaMessages.class);
  }
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
  public static ResourceBundle getResourceBundle() {
  return RESOURCE_BUNDLE;
  }		

  public static  String MiniJava_not_a_variable;
  public static  String MiniJava_Attribut_DejaDef;
  public static  String MiniJava_badtype_classe;
  public static  String MiniJava_Signature_DejaDef;
  public static  String MiniJava_unexpected_token;
  public static  String MiniJava_undefined_ident;
  public static  String MiniJava_Constructeur_DejaDef;
  public static  String MiniJava_expected_eof;
  public static  String MiniJava_classe_already_defined;
  public static  String MiniJava_interface_already_defined;
  public static  String MiniJava_already_defined;
  public static  String MiniJava_undefined_classe;
  public static  String MiniJava_expected_token;
  public static  String MiniJava_Methode_DejaDef;
  }
