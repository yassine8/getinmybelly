/* 
 * File:   ReadSignals.c
 * Author: Tom Pepels
 *
 * Created on 23 september 2011
 */

#include <stdio.h>
#include "edflib.h"

void openEDFFile(char *path, int samples);

struct edf_hdr_struct hdr;

int main() {
    //printf("Testing ECG.edf file on C: rootdir. \n");
    openEDFFile("C:\\ECG.edf", 10);
    closeEDFFile();
    return 1;
}

int openEDFFile(char *path) {
    return edfopen_file_readonly(path, &hdr, EDFLIB_DO_NOT_READ_ANNOTATIONS);
}

int closeEDFFile() {
    return edfclose_file(hdr.handle);
}

int noOfSignals() {
    return hdr.edfsignals;
}

double* ReadSamples(int signal, int samples) {
    double buf[samples];
    printf("%d Samples read. \n", edfread_physical_samples(hdr.handle, signal, samples, buf));
    return buf;
}