package homework_4.custom_file_reader.utility_classes;

import java.io.File;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractFileReader {

    protected String fileContent;

    public String getFileContent() {
        return fileContent;
    }

    protected abstract String getFileContent(File file);

    protected void fillFileContent(List<String> stringList) {
        Iterator<String> iterator = stringList.iterator();
        StringBuilder tempStringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            String tempStr = iterator.next();
            if (iterator.hasNext()) {
                tempStringBuilder.append(tempStr).append("\n");
            } else {
                tempStringBuilder.append(tempStr);
            }
        }
        fileContent = tempStringBuilder.toString();
    }

}
