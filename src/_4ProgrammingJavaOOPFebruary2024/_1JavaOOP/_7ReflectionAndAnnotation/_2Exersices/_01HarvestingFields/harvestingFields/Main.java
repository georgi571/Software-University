package _4ProgrammingJavaOOPFebruary2024._1JavaOOP._7ReflectionAndAnnotation._2Exersices._01HarvestingFields.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Map<String, List<Field>> fieldsMap = getFieldsMaps();
		String command = scanner.nextLine();
		StringBuilder stringBuilder = new StringBuilder();
		while (!command.equals("HARVEST")) {
			List<Field> fields = fieldsMap.get(command);
			for (Field field : fields) {
				stringBuilder.append(String.format("%s %s %s%n",Modifier.toString(field.getModifiers()), field.getType().getSimpleName(), field.getName()));
			}
			command = scanner.nextLine();
		}
		System.out.printf("%s",stringBuilder.toString().trim());
	}

	private static Map<String, List<Field>> getFieldsMaps() {
		Map<String, List<Field>> fieldsMap = new HashMap<>();
		fieldsMap.put("private", new ArrayList<>());
		fieldsMap.put("public", new ArrayList<>());
		fieldsMap.put("protected", new ArrayList<>());
		List<Field> allFields = Arrays.asList(RichSoilLand.class.getDeclaredFields());
		fieldsMap.put("all" , allFields);
		for (Field field : allFields) {
			if (Modifier.toString(field.getModifiers()).equals("private")) {
				fieldsMap.get("private").add(field);
			} else if (Modifier.toString(field.getModifiers()).equals("public")) {
				fieldsMap.get("public").add(field);
			} else if (Modifier.toString(field.getModifiers()).equals("protected")) {
				fieldsMap.get("protected").add(field);
			}
		}
		return fieldsMap;
	}
}
