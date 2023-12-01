package com.file.managemnet.base.services;


public interface SearchSupported<InputModel, OutputModel> {

    InputModel search(OutputModel o);

}
