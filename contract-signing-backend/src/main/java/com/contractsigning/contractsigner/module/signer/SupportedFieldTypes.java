package com.contractsigning.contractsigner.module.signer;

public enum SupportedFieldTypes {
    SIG("Sig");

    public final String value;

    private SupportedFieldTypes(String value) {
        this.value = value;
    }
}
