package com.ityuan.dubbo.design.builder;

/**
 * 建造者模式
 *
 * @Author ityuan
 * @Date 2019-06-27 11:22
 */
public class House {

    /**
     * 房子的地基
     */
    private String basic;

    /**
     * 房子的墙
     */
    private String wall;

    /**
     * 房子的屋顶
     */
    private String roof;

    public House(HouseBuilder houseBuilder) {
        this.basic = houseBuilder.basic;
        this.wall = houseBuilder.wall;
        this.roof = houseBuilder.roof;
    }

    @Override
    public String toString() {
        return "House{" +
                "basic='" + basic + '\'' +
                ", wall='" + wall + '\'' +
                ", roof='" + roof + '\'' +
                '}';
    }

    public static class HouseBuilder {

        private String basic;

        private String wall;

        private String roof;

        /**
         * 打地基
         *
         * @param basic
         * @return
         */
        public HouseBuilder buildBasic(String basic) {
            this.basic = basic;
            return this;
        }

        /**
         * 砌墙
         *
         * @param wall
         * @return
         */
        public HouseBuilder buildWall(String wall) {
            this.wall = wall;
            return this;
        }

        /**
         * 建楼顶
         *
         * @param roof
         * @return
         */
        public HouseBuilder buildRoof(String roof) {
            this.roof = roof;
            return this;
        }

        /**
         * 建造房子
         *
         * @return
         */
        public House build() {
            return new House(this);
        }
    }
}
