package edu.uniandes.hotelandes.hotel.consumptionPlan;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ConsumptionPlanRepository implements ConsumptionPlanDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ConsumptionPlanRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertConsumptionPlan(ConsumptionPlan consumptionPlan) {
        final var sql = "INSERT INTO consumption_plan( plan_name, stay_discount, fixed_cost, plan_description) VALUES( ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, consumptionPlan.plan_name(), consumptionPlan.plan_discount(), consumptionPlan.fixed_cost(), consumptionPlan.plan_description());
    }

    @Override
    public Optional<ConsumptionPlan> selectConsumptionPlanById(int id) {
        final var sql = "SELECT id, plan_name, stay_discount, fixed_cost, plan_description FROM consumption_plan WHERE id = ?";
        final var consumptionPlans = jdbcTemplate.query(sql, new ConsumptionPlanRowMapper(), id);
        return consumptionPlans.stream().findFirst();
    }

    @Override
    public List<ConsumptionPlan> selectConsumptionPlans() {
        final var sql = "SELECT id, plan_name, stay_discount, fixed_cost, plan_description FROM consumption_plan";
        return jdbcTemplate.query(sql, new ConsumptionPlanRowMapper());
    }

    @Override
    public int updateConsumptionPlan(int id, ConsumptionPlan consumptionPlan) {
        final var sql = "UPDATE consumption_plan SET plan_name = ?, stay_discount = ?, fixed_cost = ?, plan_description = ? WHERE id = ?";
        return jdbcTemplate.update(sql, consumptionPlan.plan_name(), consumptionPlan.plan_discount(), consumptionPlan.fixed_cost(), consumptionPlan.plan_description(), id);
    }

    @Override
    public int deleteConsumptionPlan(int id) {
        final var sql = "DELETE FROM consumption_plan WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }


}
