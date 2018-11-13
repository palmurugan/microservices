package com.ms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.ms.generator.app.ApplicationGenerator;
import com.ms.vo.MetaDataVO;

/**
 * 
 * @author palmuruganc
 *
 */
public class AppGenerator {
	public static void main(String[] args) {
		Gson gson = new Gson();
		try (FileReader reader = new FileReader("metadata/metadata.json")) {
			buildCode(gson.fromJson(new JsonReader(reader), MetaDataVO.class));
			System.out.println("======== Done =======");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void buildCode(MetaDataVO metaData) {
		new ApplicationGenerator().generate(metaData);
	}
}
