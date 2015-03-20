package de.knoobie.project.nagisa.gson.model.dto.json.common;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

public @Data class Names {

    private String en;
    private String English;
    @SerializedName("English (from furigana)")
    private String eng_furigana;
    private String ja;
    @SerializedName("ja-latn")
    private String ja_latn;
    @SerializedName("Japanese (furigana)")
    private String ja_furigana;
    @SerializedName("Romaji")
    private String romaji;
    @SerializedName("Original")
    private String original;
}