package com.hts.report.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.hts.report.domain.Resource;
import com.hts.report.dto.ColumnData;
import com.hts.report.service.IQueryExecutor;

/**
 * 
 * @author PalMurugan C
 *
 */
@Service
public class MySQLQueryExecutor extends ConnectionManager implements IQueryExecutor {

    @Override
    public Object executeQuery(Resource resource, String sql) {
        JdbcTemplate template = getJDBCTemplate(resource);
        return template.queryForList(sql);
    }

    @Override
    public List<ColumnData> getAvailableColumns(Resource resource, String sql) {
        JdbcTemplate template = getJDBCTemplate(resource);
        List<ColumnData> availableColumns = template.query(sql, new RowMapper<ColumnData>() {

            @Override
            public ColumnData mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                return new ColumnData(resultSet.getString(1), resultSet.getString(2));
            }
        });
        return availableColumns;
    }
}
