package tk.tinkerit.spring.dynoconfig;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DynamicAppConfig implements Serializable {
    private static final long serialVersionUID = 303770154458776110L;

    private List<RightUseSource> rightUseSources;

    private ContractConfig contractConfig = new ContractConfig();

    private CommonConfig commonConfig = new CommonConfig();

    private CardSalesConfig cardSales = new CardSalesConfig();

    private RightConfig rightConfig = new RightConfig();

    public DynamicAppConfig() {
    }

    public List<RightUseSource> getRightUseSources() {
        return rightUseSources;
    }

    public void setRightUseSources(List<RightUseSource> rightUseSources) {
        this.rightUseSources = rightUseSources;
    }

    public ContractConfig getContractConfig() {
        return contractConfig;
    }

    public void setContractConfig(ContractConfig contractConfig) {
        this.contractConfig = contractConfig;
    }

    public CommonConfig getCommonConfig() {
        return commonConfig;
    }

    public void setCommonConfig(CommonConfig commonConfig) {
        this.commonConfig = commonConfig;
    }

    public CardSalesConfig getCardSales() {
        return cardSales;
    }

    public void setCardSales(CardSalesConfig cardSales) {
        this.cardSales = cardSales;
    }

    public RightConfig getRightConfig() {
        return rightConfig;
    }

    public void setRightConfig(RightConfig rightConfig) {
        this.rightConfig = rightConfig;
    }

    public static class RightUseSource {

        private String code;

        private int value;

        private String serviceDesc;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String getServiceDesc() {
            return serviceDesc;
        }

        public void setServiceDesc(String serviceDesc) {
            this.serviceDesc = serviceDesc;
        }

        @Override
        public String toString() {
            return "RightUseSource{" +
                    "code='" + code + '\'' +
                    ", value=" + value +
                    ", serviceDesc='" + serviceDesc + '\'' +
                    '}';
        }
    }

    public static class ContractConfig implements Serializable {
        private static final long serialVersionUID = 2089568358111179478L;

        /** 批量导入合同成员文件大小限制（单位：KB） */
        private int importFileMaxSize = 10 * 1024;

        private String exportAcCodeMsmTpl;

        public int getImportFileMaxSize() {
            return importFileMaxSize;
        }

        public void setImportFileMaxSize(int importFileMaxSize) {
            this.importFileMaxSize = importFileMaxSize;
        }

        public String getExportAcCodeMsmTpl() {
            return exportAcCodeMsmTpl;
        }

        public void setExportAcCodeMsmTpl(String exportAcCodeMsmTpl) {
            this.exportAcCodeMsmTpl = exportAcCodeMsmTpl;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }

    public static class CardSalesConfig implements Serializable {
        private static final long serialVersionUID = 5741680734299784561L;

        private int pageSize = 1000;

        private List<CSTeamConfig> csTeams = Collections.unmodifiableList(Collections.emptyList());

        private List<FinanceCategory> financeCategories = Collections.unmodifiableList(Collections.emptyList());

        /** 电视购物渠道下单的sku id */
        private long tvBuySkuId;

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public List<CSTeamConfig> getCsTeams() {
            return csTeams;
        }

        public List<CSTeamConfig> findMatchingCsTeams(String name) {
            if (StringUtils.isBlank(name))
                return csTeams;
            return csTeams.stream()
                    .filter(t -> t.getEntranceName().contains(name))
                    .collect(Collectors.toList());
        }

        public CSTeamConfig getCsTeamById(String id) {
            if (StringUtils.isBlank(id))
                return null;
            return csTeams.stream()
                    .filter(t -> id.equals(t.entranceId))
                    .findFirst()
                    .orElse(null);
        }

        public void setCsTeams(List<CSTeamConfig> csTeams) {
            this.csTeams = Collections.unmodifiableList(csTeams);
        }

        public List<FinanceCategory> getFinanceCategories() {
            return financeCategories;
        }

        public List<FinanceCategory> findMatchingFinanceCategories(String name) {
            if (StringUtils.isBlank(name))
                return financeCategories;
            return financeCategories.stream()
                    .filter(t -> t.getName().contains(name))
                    .collect(Collectors.toList());
        }

        public FinanceCategory findFinanceCategory(String code) {
            return financeCategories.stream()
                    .filter(category -> category.getCode().equals(code))
                    .findFirst()
                    .orElse(null);
        }

        public void setFinanceCategories(List<FinanceCategory> financeCategories) {
            this.financeCategories = Collections.unmodifiableList(financeCategories);
        }

        public long getTvBuySkuId() {
            return tvBuySkuId;
        }

        public void setTvBuySkuId(long tvBuySkuId) {
            this.tvBuySkuId = tvBuySkuId;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
        }
    }

    public static class CSTeamConfig implements Serializable {
        private static final long serialVersionUID = 4132960156347013865L;

        private String entranceId;

        private String entranceName;

        public String getEntranceId() {
            return entranceId;
        }

        public void setEntranceId(String entranceId) {
            this.entranceId = entranceId;
        }

        public String getEntranceName() {
            return entranceName;
        }

        public void setEntranceName(String entranceName) {
            this.entranceName = entranceName;
        }

        @Override
        public String toString() {
            return "CSTeamConfig{" +
                    "entranceId=" + entranceId +
                    ", entranceName='" + entranceName + '\'' +
                    '}';
        }
    }

    public static class FinanceCategory implements Serializable {
        private static final long serialVersionUID = 4132960156347013865L;

        private String code;

        private String name;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("FinanceCategory{");
            sb.append("code='").append(code).append('\'');
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    public static class CommonConfig implements Serializable {

        private static final long serialVersionUID = 5362505052465664720L;

        // 卡二级类目id
        private long cardParentCategoryId;

        // 服务商品二级类目id
        private long spParentCategoryId;

        // 卡定时任务短信通知模版
        private String cardScheduleTaskNoticeTpl;

        public long getCardParentCategoryId() {
            return cardParentCategoryId;
        }

        public void setCardParentCategoryId(long cardParentCategoryId) {
            this.cardParentCategoryId = cardParentCategoryId;
        }

        public long getSpParentCategoryId() {
            return spParentCategoryId;
        }

        public void setSpParentCategoryId(long spParentCategoryId) {
            this.spParentCategoryId = spParentCategoryId;
        }

        public String getCardScheduleTaskNoticeTpl() {
            return cardScheduleTaskNoticeTpl;
        }

        public void setCardScheduleTaskNoticeTpl(String cardScheduleTaskNoticeTpl) {
            this.cardScheduleTaskNoticeTpl = cardScheduleTaskNoticeTpl;
        }

        @Override
        public String toString() {
            return "CommonConfig{" +
                    "cardParentCategoryId=" + cardParentCategoryId +
                    ", spParentCategoryId=" + spParentCategoryId +
                    ", cardScheduleTaskNoticeTpl='" + cardScheduleTaskNoticeTpl + '\'' +
                    '}';
        }
    }

    public static class RightConfig implements Serializable {

        private static final long serialVersionUID = 8196035033452228568L;

        private int bulkExtendMaxNum = 500;

        private int rightWriteSize = 1000;

        private int rightWriteUpper = 10000;

        public int getBulkExtendMaxNum() {
            return bulkExtendMaxNum;
        }

        public void setBulkExtendMaxNum(int bulkExtendMaxNum) {
            this.bulkExtendMaxNum = bulkExtendMaxNum;
        }

        public int getRightWriteSize() {
            return rightWriteSize;
        }

        public void setRightWriteSize(int rightWriteSize) {
            this.rightWriteSize = rightWriteSize;
        }

        public int getRightWriteUpper() {
            return rightWriteUpper;
        }

        public void setRightWriteUpper(int rightWriteUpper) {
            this.rightWriteUpper = rightWriteUpper;
        }

        @Override
        public String toString() {
            return "RightConfig{" +
                    "bulkExtendMaxNum=" + bulkExtendMaxNum +
                    ", rightWriteSize=" + rightWriteSize +
                    ", rightWriteUpper=" + rightWriteUpper +
                    '}';
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
