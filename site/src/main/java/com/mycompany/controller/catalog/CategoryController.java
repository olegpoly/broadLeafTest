/*
 * Copyright 2008-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mycompany.controller.catalog;

import org.apache.commons.lang.StringUtils;
import org.broadleafcommerce.common.extension.ExtensionResultHolder;
import org.broadleafcommerce.core.catalog.domain.Category;
import org.broadleafcommerce.core.catalog.domain.Product;
import org.broadleafcommerce.core.search.domain.ProductSearchCriteria;
import org.broadleafcommerce.core.search.domain.ProductSearchResult;
import org.broadleafcommerce.core.search.domain.SearchFacetDTO;
import org.broadleafcommerce.core.web.catalog.CategoryHandlerMapping;
import org.broadleafcommerce.core.web.controller.catalog.BroadleafCategoryController;
import org.broadleafcommerce.core.web.util.ProcessorUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * This class works in combination with the CategoryHandlerMapping which finds a category based upon
 * the passed in URL.
 */
@Controller("blCategoryController")
public class CategoryController extends BroadleafCategoryController {

    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = super.handleRequest(request, response);

        addObjects(modelAndView);

        return modelAndView;
    }

    private void addObjects(ModelAndView model) {
        addCategories(model);

        @SuppressWarnings("unchecked")
        List<SearchFacetDTO> searchFacets = (List<SearchFacetDTO>) model.getModel().get(FACETS_ATTRIBUTE_NAME);

        model.addObject("sizes", getSizeFacets(model, searchFacets));
        model.getModel().put(FACETS_ATTRIBUTE_NAME, searchFacets);
    }

    private void addCategories(ModelAndView model) {
        model.addObject("categories", Arrays.asList(1, 2, 3, 4));
    }

    private List<?> getSizeFacets(ModelAndView model, List<SearchFacetDTO> searchFacets) {
        List<SearchFacetDTO> sizeFacets = new ArrayList<SearchFacetDTO>();

        for (SearchFacetDTO searchFacet : searchFacets) {
            String label = searchFacet.getFacet().getLabel();

            if (label.equals("euSize") ||
                    label.equals("usSize") ||
                    label.equals("ukSize")) {
                sizeFacets.add(searchFacet);
            }
        }

        searchFacets.removeAll(sizeFacets);

        return sizeFacets;
    }

}
