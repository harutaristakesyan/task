package com.admin.core.supported;


public interface SearchSupported<InputModel, OutputModel> {

    OutputModel search(InputModel i);

}
