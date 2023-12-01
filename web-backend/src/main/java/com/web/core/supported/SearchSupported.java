package com.web.core.supported;


public interface SearchSupported<InputModel, OutputModel> {

    OutputModel search(InputModel inputModel);

}
