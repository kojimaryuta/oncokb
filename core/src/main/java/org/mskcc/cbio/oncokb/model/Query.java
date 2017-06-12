package org.mskcc.cbio.oncokb.model;
// Generated Dec 19, 2013 1:33:26 AM by Hibernate Tools 3.2.1.GA

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * TumorType generated by hbm2java
 */
public class Query implements java.io.Serializable {
    private String id; //Optional, This id is passed from request. The identifier used to distinguish the query
    private String type; // Query type. Different type may return different result.
    private String hugoSymbol;
    private Integer entrezGeneId;
    private String alteration;
    private String alterationType;
    private String tumorType;
    private String consequence;
    private Integer proteinStart;
    private Integer proteinEnd;

    public Query() {
    }

    public Query(Alteration alt) {
        if (alt != null) {
            if (alt.getGene() != null) {
                this.hugoSymbol = alt.getGene().getHugoSymbol();
                this.entrezGeneId = alt.getGene().getEntrezGeneId();
            }
            this.alteration = alt.getAlteration();
            this.alterationType = alt.getAlterationType() == null ? "MUTATION" : alt.getAlterationType().name();
            this.consequence = alt.getConsequence() == null ? null : alt.getConsequence().getTerm();
            this.proteinStart = alt.getProteinStart();
            this.proteinEnd = alt.getProteinEnd();
        }
    }

    public Query(VariantQuery variantQuery) {
        if (variantQuery != null) {
            if (variantQuery.getGene() != null) {
                this.hugoSymbol = variantQuery.getGene().getHugoSymbol();
                this.entrezGeneId = variantQuery.getGene().getEntrezGeneId();
            }
            this.alteration = variantQuery.getQueryAlteration();
            this.consequence = variantQuery.getConsequence();
            this.proteinStart = variantQuery.getProteinStart();
            this.proteinEnd = variantQuery.getProteinEnd();
        }
    }

    public Query(String hugoSymbol, String alteration, String tumorType) {
        this.hugoSymbol = hugoSymbol;
        this.alteration = alteration;
        this.setTumorType(tumorType);
    }

    public Query(String id, String type, Integer entrezGeneId, String hugoSymbol, String alteration, String alterationType, String tumorType, String consequence, Integer proteinStart, Integer proteinEnd) {
        this.id = id;
        this.type = type;
        if (hugoSymbol != null && !hugoSymbol.isEmpty()) {
            this.hugoSymbol = hugoSymbol;
        }
        this.entrezGeneId = entrezGeneId;
        this.alteration = alteration;
        this.alterationType = alterationType;
        this.setTumorType(tumorType);
        this.consequence = consequence;
        this.proteinStart = proteinStart;
        this.proteinEnd = proteinEnd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHugoSymbol() {
        return hugoSymbol;
    }

    public void setHugoSymbol(String hugoSymbol) {
        this.hugoSymbol = hugoSymbol;
    }

    public Integer getEntrezGeneId() {
        return entrezGeneId;
    }

    public void setEntrezGeneId(Integer entrezGeneId) {
        this.entrezGeneId = entrezGeneId;
    }

    public String getAlteration() {
        return alteration;
    }

    public void setAlteration(String alteration) {
        this.alteration = alteration;
    }

    public String getAlterationType() {
        return alterationType;
    }

    public void setAlterationType(String alterationType) {
        this.alterationType = alterationType;
    }

    public String getTumorType() {
        return tumorType;
    }

    public void setTumorType(String tumorType) {
        if (tumorType != null) {
            tumorType = tumorType.trim();
        }
        this.tumorType = tumorType;
    }

    public String getConsequence() {
        return consequence;
    }

    public void setConsequence(String consequence) {
        this.consequence = consequence;
    }

    public Integer getProteinStart() {
        return proteinStart;
    }

    public void setProteinStart(Integer proteinStart) {
        this.proteinStart = proteinStart;
    }

    public Integer getProteinEnd() {
        return proteinEnd;
    }

    public void setProteinEnd(Integer proteinEnd) {
        this.proteinEnd = proteinEnd;
    }

    @JsonIgnore
    public String getQueryId() {

        List<String> content = new ArrayList<>();
        if (this.entrezGeneId != null) {
            content.add(Integer.toString(this.entrezGeneId));
        } else {
            if (this.hugoSymbol != null) {
                content.add(this.hugoSymbol);
            } else {
                content.add("");
            }
        }
        if (this.alteration != null) {
            content.add(this.alteration);
        } else {
            content.add("");
        }
        if (this.alterationType != null) {
            content.add(this.alterationType);
        } else {
            content.add("");
        }
        if (this.type != null) {
            content.add(this.type);
        } else {
            content.add("");
        }
        if (this.tumorType != null) {
            content.add(this.tumorType);
        } else {
            content.add("");
        }
        if (consequence != null) {
            content.add(this.consequence);
        } else {
            content.add("");
        }
        if (this.proteinStart != null) {
            content.add(Integer.toString(this.proteinStart));
        } else {
            content.add("");
        }
        if (this.proteinEnd != null) {
            content.add(Integer.toString(this.proteinEnd));
        } else {
            content.add("");
        }

        return StringUtils.join(content.toArray(), "&");
    }
}


