package com.ebsco.JsonToXml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ebsco.JsonToXml.model.CollectionDetails;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

/**
 * 
 *
 */
public class JsonToXml {
	public static void main(String[] args) {
		String fileName = "./input/output_New.json";
		List<CollectionDetails> collectionDetailsList = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			System.out.println("*****Reading JSON file*****" + fileName);
			collectionDetailsList = Arrays
					.asList(objectMapper.readValue(Paths.get(fileName).toFile(), CollectionDetails[].class));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String path = "./input/pubmedList.txt";
		List<String> pubmedList = null;
		try {
			pubmedList = Files.readAllLines(Paths.get(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JsonToXml jsonToXml = new JsonToXml();
		jsonToXml.writeXmlFile(collectionDetailsList, pubmedList);

		System.out.println("Writing xml file completed ");

	}

	public void writeXmlFile(List<CollectionDetails> collectionDetailsList, List<String> pubmedList) {
		List<CollectionDetails> meta = new ArrayList<CollectionDetails>();
		List<String> pubmedIdNotFoundList = new ArrayList<String>();		
		pubmedIdNotFoundList.add("List of Pubmed Id not found");
		for (int i = 0; i < pubmedList.size(); i++) {
			Boolean foundBoolean = false;
			for (int x = 0; x < collectionDetailsList.size(); x++) {
				if (pubmedList.get(i).equals(collectionDetailsList.get(x).getCitation_pmid())) {
					removeBlankSpacetagsAndNulltags(collectionDetailsList.get(x));
					meta.add(collectionDetailsList.get(x));
					foundBoolean = true;
				} else if (x == collectionDetailsList.size()-1 && foundBoolean == false) {
					pubmedIdNotFoundList.add(pubmedList.get(i));
				}
			}
		};
		System.out.println(" Total PebmedId Fetched "+ meta.size());
		System.out.println("****Writing data to xml file ****");
		String outputFile = "./output/testoutput.xml";
		String pubmedIdNotFoundFileString = "./output/List_of_pubmedNotFoundList.txt";
		File file = new File(outputFile);
		XmlMapper xmlMapper = new XmlMapper();
		xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
		xmlMapper.setDefaultUseWrapper(false);
		try {
			xmlMapper.writeValue(file, meta);
			notFoundPubmedList(pubmedIdNotFoundList, pubmedIdNotFoundFileString);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeBlankSpacetagsAndNulltags(CollectionDetails collectionDetails) {
		if(collectionDetails.getCitation_authors() != null) {
			StringBuilder build = new StringBuilder();
			String[] authorsNamesArray = collectionDetails.getCitation_authors().split("\\s*;");
			for(String names : authorsNamesArray ) {
				build.append(names);
				build.append(";");
			}
		 	collectionDetails.setCitation_authors(build.toString());
		}
		if(collectionDetails.getCollab_author() != null) {
			StringBuilder build = new StringBuilder();
			String[] collabAuthorsNamesArray = collectionDetails.getCollab_author().split("\\s*;");
			for(String names : collabAuthorsNamesArray ) {
				build.append(names);
				build.append(";");
			}
			collectionDetails.setCollab_author(build.toString());
		}
		if(collectionDetails.getCitation_abstract_html_url() != null ) {
			String url = collectionDetails.getCitation_abstract_html_url().replaceAll("/$", "");
			collectionDetails.setCitation_abstract_html_url(url);
		}
	}
	
	public void notFoundPubmedList(List<String> list, String path) {
		try {
			File file = new File(path);
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            System.out.println("***Writing list of pubmedId which not found ***");
            for (String str : list) {
                writer.write(str);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
