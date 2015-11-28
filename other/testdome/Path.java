import java.util.ArrayList;
import java.util.Arrays;

public class Path {
    
    /*
     * Write a function that provides change directory (cd) function for an 
     * abstract file system.
     *
     * Notes:
     *
     * Root path is '/'.
     * Path separator is '/'.
     * Parent directory is addressable as "..".
     * Directory names consist only of English alphabet letters (A-Z and a-z).
     *
     * For example, new Path("/a/b/c/d").cd("../x").getPath() should 
     * return "/a/b/c/x".
     * 
     * Note: The evaluation environment uses '\' as the path separator.
     */

    private String path;

    public Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public Path cd(String newPath) {
        
        String delimiter = "/";
        String root = "/";
        boolean isRoot = false;

        // parse new path into tokens
        String[] tokensNewPath = newPath.split(delimiter);

        // parse current path into tokens
        ArrayList<String> tokensCurrentPath = new ArrayList<String>(Arrays.asList(path.split(delimiter)));
     
        // if first character in newPath specifies root "/", then clear current path
        if (newPath.substring(0, 1).equals(root)) {
            tokensCurrentPath.clear();
            isRoot = true;
        }

        // for each token in new path, modify current path appropriately
        for (int i = 0; i < tokensNewPath.length; i++) {

            // if token is "..", then remove one level from current path
            if (tokensNewPath[i].equals("..")) {
                tokensCurrentPath.remove(tokensCurrentPath.size() - 1);
            }

            // if token is A-Z,a-z letters, then add directory to current path
            if (tokensNewPath[i].matches("[A-Za-z]+")) {
                tokensCurrentPath.add(tokensNewPath[i]);
            }
        }

        // convert modified path tokens to new path string
        StringBuilder strNewPath = new StringBuilder();
        if (isRoot) {
            strNewPath.append(root);
        }
        for (int t = 0; t < tokensCurrentPath.size(); t++) {
            strNewPath.append(tokensCurrentPath.get(t));
            if (t != tokensCurrentPath.size() - 1) {
                strNewPath.append(delimiter);
            }
        }
        return new Path(strNewPath.toString());
    }

    public static void main(String[] args) {
        Path path = new Path("/a/b/c/d");
        
        // output: "/a/b/c/x"
        System.out.println(path.cd("../x").getPath());
        
        // output: "/a/b/y"
        System.out.println(path.cd("../../y").getPath());
        
        // output: "/a/z"
        System.out.println(path.cd("../../../z").getPath());
    
        // output: "/test"
        System.out.println(path.cd("/test").getPath());
        
        // output: "/a"
        System.out.println(path.cd("/test/../a").getPath());
    }
}
