package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br>
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes() {
        ArrayList<String> recipes = new ArrayList<>();
        try {
            // ファイルを読み込み
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                // 各行をリストに追加
                recipes.add(line);
            }
            reader.close();
        } catch (IOException e) {
            // 例外発生時のエラーメッセージ表示
            System.out.println("Error reading file: " + e.getMessage());
        }
        return recipes;
    }

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName レシピ名
     * @param ingredients 材料名
     */
     //
    public void addRecipe(String recipeName, String ingredients) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // レシピをファイルに追加
            writer.write(recipeName + "," + ingredients);
            writer.newLine(); // 新しい行に追加
        } catch (IOException e) {
            // エラー発生時のメッセージ表示
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
