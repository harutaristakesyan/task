package com.i18n.base.services;

public interface SearchSupported<InputModel, OutputModel> {

    InputModel search(OutputModel o);

}
