package squad25.comercioFacil.enums;

public enum SystemAlert {
	SUCCESSFUL_OPERATION("Sucesso!", "Operação bem-sucedida."),
	
	OPERATION_ERROR("Erro!", "Falha na operação."),
	NOT_FOUND_ERROR("Erro!", "registro não encontrado.");
	
	private final String title;
	private final String message;
   
	private SystemAlert(String title, String message) {
		this.title = title;
		this.message = message;
	}
	
	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public static RuntimeException printRuntimeEx(SystemAlert alert) {
    	return new RuntimeException("## Alerta: "+ alert.title + " - " + alert.message + " ##\n");
    }
    
    public static void printSuccess(SystemAlert alert) {
    	System.out.println("\n\n # "+ alert.message + " #\n");
    }
}