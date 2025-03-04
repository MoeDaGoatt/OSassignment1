package org.example;

import java.util.Random;

public class MemoryManagementSimulator {
       int TOTAL_MEMORY_PAGES = 100;
       int PAGE_SIZE_MB = 160;
       int START_ADDRESS = 2000;

     final MemoryPage[] memory = new MemoryPage[TOTAL_MEMORY_PAGES];
     int currentAddress = START_ADDRESS;
     final Random random = new Random();

    public void userMemoryAllocation() {
        int processId = 1;
        int pageIndex = 0;

        while (pageIndex < TOTAL_MEMORY_PAGES) {
            int pagesNeeded = random.nextInt(30) + 1;
            int processSize = pagesNeeded * 80;
            int pagesRequired = (int) Math.ceil((double) processSize / PAGE_SIZE_MB);

            if (pageIndex + pagesRequired > TOTAL_MEMORY_PAGES) {
                break;
            }

            int allocatedSize = pagesRequired * PAGE_SIZE_MB;
            int unusedSpace = allocatedSize - processSize;

            for (int i = 0; i < pagesRequired; i++) {
                memory[pageIndex + i] = new MemoryPage();
                memory[pageIndex + i].processId = processId;
                memory[pageIndex + i].startAddress = currentAddress;
                memory[pageIndex + i].size = processSize;
                memory[pageIndex + i].unusedSpace = unusedSpace;
            }

            System.out.printf("%-15d %-25d %-30d %-20d\n", processId, currentAddress, processSize, unusedSpace);

            currentAddress += allocatedSize;
            pageIndex += pagesRequired;
            processId++;
        }
    }
}
