package service;

import entity.Provider;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProviderService extends Provider {
    private static final String FILE_PROVIDER = "C:\\Users\\ADMIN\\Desktop\\New folder (2)\\Case Study Module 2\\untitled\\src\\data\\dataProvider.txt";
    public static List<Provider> providerList = new ArrayList<>();

    public static void saveProvider() {
        try {
            FileWriter fileWriter = new FileWriter(FILE_PROVIDER, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Provider provider = providerList.get(providerList.size() - 1);
            bufferedWriter.write(provider.toFileProvider() + "\n");
            bufferedWriter.close();
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Provider> loadProviderFromFile() {
        try {
            FileReader fileReader = new FileReader(FILE_PROVIDER);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;

            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = new String[4];
                arr = line.split(",");
                Provider provider = new Provider(arr[0], arr[1], arr[2], arr[3]);
                providerList.add(provider);
                System.out.println();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return providerList;
    }

    public static void addProvider(Provider provider) {
        providerList.add(provider);
        saveProvider();
    }

    public static void updateProvider(String providerName, Provider updateProvider, List<Provider> providerListForUpDate) {
        Provider providerToUpdate = null;
        for (Provider provider : providerListForUpDate) {
            if (provider.getProviderName().equalsIgnoreCase(providerName)) {
                providerToUpdate = provider;
                break;
            }
        }

        if (providerToUpdate == null) {
            System.out.println("Provider not found: " + providerName);
            return;
        }

        providerListForUpDate.remove(providerToUpdate);
        providerListForUpDate.add(updateProvider);

        try (FileWriter fileWriter = new FileWriter(FILE_PROVIDER);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Provider provider : providerListForUpDate) {
                bufferedWriter.write(provider.toFileProvider());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteProviderByName(String providerName) {
        boolean providerFound = false;
        Provider providerToRemove = null;

        for (int i = 0; i < providerList.size(); i++) {
            Provider provider = providerList.get(i);
            if (provider.getProviderName().equalsIgnoreCase(providerName)) {
                providerToRemove = provider;
                providerFound = true;
                break;
            }
        }

        if (providerFound) {
            providerList.remove(providerToRemove);
            try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PROVIDER))) {
                for (Provider provider : providerList) {
                    writer.println(provider.toFileProvider());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Provider removed successfully.");
        } else {
            System.err.println("Provider not found.");
        }
    }

    public static void viewProviders(){
        try {
            FileReader fileReader = new FileReader(FILE_PROVIDER);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean findProviderByName(String providerName, List<Provider> providerListForFinding) {
        for (Provider provider : providerListForFinding) {
            if (provider.getProviderName().equalsIgnoreCase(providerName)) {
                return true;
            }
        }
        return false;
    }

    public static void findProvider(String providerName, List<Provider> providerListForFinding) {
        for (Provider provider : providerListForFinding) {
            if (provider.getProviderName().equalsIgnoreCase(providerName)) {
                System.out.println(provider);
                return;
            }
        }
    }
}