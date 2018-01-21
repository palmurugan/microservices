package com.hts.report.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.genesis.common.domain.Auditable;

/**
 * 
 * @author PalMurugan C
 *
 */
@Entity
@Table(name = "PSR_COLUMN")
public class ReportColumn extends Auditable<String> implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "COLUMN_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "DEFINITION_ID", nullable = false)
    @JsonBackReference
    private ReportDefinition reportDefinition;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;
    
    @Column(name = "SEQUENCE", nullable = false)
    private Integer sequence;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReportDefinition getReportDefinition() {
        return reportDefinition;
    }

    public void setReportDefinition(ReportDefinition reportDefinition) {
        this.reportDefinition = reportDefinition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}
